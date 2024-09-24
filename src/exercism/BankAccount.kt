package exercism

import org.junit.Test
import java.util.*
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.locks.ReentrantReadWriteLock
import kotlin.concurrent.read
import kotlin.concurrent.write
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class BankAccount {

    private var closed = false

    private val lock = ReentrantReadWriteLock()

    var balance: Long = 0L
        private set
        get() {
            lock.read {
                if (closed) {
                    throw IllegalStateException("Account is closed")
                }
                return field
            }
        }

    fun adjustBalance(amount: Long){
        lock.write {
            if (closed) {
                throw IllegalStateException("Account is closed")
            }
            balance += amount
        }
    }

    fun close() {
        lock.write {
            closed = true
        }
    }
}


class BankAccountTest {

    @Test
    fun zeroBalanceWhenOpened() {
        val account = BankAccount()
        assertEquals(0, account.balance)
    }

    @Test
    fun sequentialBalanceAdjustments() {
        val account = BankAccount()

        account.adjustBalance(1000)
        assertEquals(1000, account.balance)

        account.adjustBalance(-958)
        assertEquals(42, account.balance)
    }

    @Test
    fun closedAccountHasNoBalance() {
        val account = BankAccount()
        account.close()

        assertFailsWith(IllegalStateException::class) { account.balance }
    }

    @Test
    fun closedAccountCannotBeAdjusted() {
        val account = BankAccount()
        account.close()

        assertFailsWith(IllegalStateException::class) { account.adjustBalance(1000) }
    }

    @Test
    fun concurrentBalanceAdjustments() {
        val threads = 100
        val iterations = 500
        val random = Random()

        val account = BankAccount()

        val executor = Executors.newFixedThreadPool(8)

        repeat(threads) {
            executor.submit {
                repeat(iterations) {
                    account.adjustBalance(1)
                    Thread.sleep(random.nextInt(10).toLong())
                    account.adjustBalance(-1)
                }
            }
        }

        executor.shutdown()
        executor.awaitTermination(10, TimeUnit.MINUTES)

        assertEquals(0, account.balance)
    }

}

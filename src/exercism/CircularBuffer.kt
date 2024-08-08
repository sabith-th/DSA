package exercism

class EmptyBufferException: Exception()

class BufferFullException: Exception()

class CircularBuffer<T>(private val capacity: Int) {
    var buffer: ArrayDeque<T>


    init {
        buffer = ArrayDeque<T>()
    }

    fun read() : T {
        if (buffer.isEmpty()) {
            throw EmptyBufferException()
        }
        return buffer.removeFirst()
    }

    fun write(value: T) {
        if (buffer.size == capacity) {
            throw BufferFullException()
        }
        buffer.add(value)
    }

    fun overwrite(value: T) {
        if (buffer.size == capacity) {
            buffer.removeFirst()
        }
        buffer.add(value)
    }

    fun clear() {
        buffer.clear()
    }
}
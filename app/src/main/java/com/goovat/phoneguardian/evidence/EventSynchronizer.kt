package com.goovat.phoneguardian.evidence

class EventSynchronizer(
    private val queue: OfflineEventQueue,
    private val transport: EventTransport
) {

    fun synchronize(): Result<Unit> {
        for (event in queue.events()) {
            val result = transport.send(event)

            if (result.isFailure) {
                return result
            }

            queue.remove(event)
        }

        return Result.success(Unit)
    }
}

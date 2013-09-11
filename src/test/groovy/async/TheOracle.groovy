package async

import java.util.concurrent.atomic.AtomicInteger

class TheOracle {
  private AtomicInteger count = new AtomicInteger(0)

  void ask(String question, Closure callback) {
    int next = count.incrementAndGet()
    Thread.start {
      Thread.sleep(next * 1000)
      callback.call(next == 1 ? "Java" : "Groovy. But don't tell anyone that you heard it from me.")
    }
  }
}

package async

import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.AtomicInteger

class PollableOracle {
  private final AtomicInteger count = new AtomicInteger(0)
  private final Map<Integer, String> answers = new ConcurrentHashMap<Integer, String>()

  int ask(String question) {
    int next = count.incrementAndGet()
    Thread.start {
      Thread.sleep(next * 1000)
      answers[next] = next == 1 ? "Java" : "Groovy. But don't tell anyone that you heard it from me."
    }
    next
  }

  String getAnswer(int token) {
    answers.containsKey(token) ? answers[token] : null
  }
}

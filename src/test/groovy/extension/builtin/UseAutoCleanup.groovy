package extension.builtin

import spock.lang.AutoCleanup
import spock.lang.Specification

class UseAutoCleanup extends Specification {
  @AutoCleanup resource1 = new Resource1()
  @AutoCleanup resource2 = new Resource2()
  @AutoCleanup("dispose") resource3 = new Resource3()

  def "test using resources"() {
    expect:
    resource1 instanceof Resource1
    resource2 instanceof Resource2
    resource3 instanceof Resource3
  }
}

class Resource1 implements Closeable {
  void close() {
    println "closing 1"
  }
}

class Resource2 {
  void close() {
    println "closing 2"
    //throw new IOException("ouch")
  }
}

class Resource3 {
  void dispose() {
    println "closing 3"
  }
}

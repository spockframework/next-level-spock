package rule

import org.junit.ClassRule
import org.junit.rules.TemporaryFolder

import spock.lang.Specification
import spock.lang.Shared

class UsePerClassTemporaryFolder extends Specification {
  @ClassRule @Shared TemporaryFolder folder = new TemporaryFolder()

  def setupSpec() {
    assert folder.root.exists()
  }

  def "first file-based test"() {
    expect:
    println folder.newFile("file")
  }

  def "second file-based test"() {
    expect:
    println folder.newFile("file")
  }
}

package rule

import org.junit.rules.TemporaryFolder
import org.junit.Rule

import spock.lang.Specification

class UseTemporaryFolder extends Specification {
  @Rule TemporaryFolder folder = new TemporaryFolder()

  def setup() {
    assert folder.root.exists()
  }

  def "some file-based test"() {
    when:
    def file = folder.newFile("file")
    def sub = folder.newFolder("subfolder")

    then:
    file.exists()
    sub.exists()
  }
}

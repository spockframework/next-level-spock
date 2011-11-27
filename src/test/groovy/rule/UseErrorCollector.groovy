package rule

import org.junit.Rule
import org.junit.rules.ErrorCollector

import spock.lang.Specification

import static org.hamcrest.CoreMatchers.equalTo

class UseErrorCollector extends Specification {
  @Rule ErrorCollector collector = new ErrorCollector()

  def "busy test"() {
    expect:
    collector.checkThat(1 + 2, equalTo(3))
    collector.checkThat(2 + 3, equalTo(5))
    collector.checkThat(3 + 4, equalTo(7))
  }
}

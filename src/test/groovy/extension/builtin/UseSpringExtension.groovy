package extension.builtin

import javax.sql.DataSource
import groovy.sql.Sql

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.transaction.BeforeTransaction
import org.springframework.transaction.annotation.Transactional

import spock.lang.Shared
import spock.lang.Specification

@ContextConfiguration(locations = "UseSpringExtension-context.xml")
class UseSpringExtension extends Specification {
  @Shared
  Sql sql

  @Shared
  boolean tableCreated = false

  @Autowired
  DataSource dataSource

  @BeforeTransaction
  def createTable() {
    if (tableCreated) return
    sql = new Sql(dataSource)
    sql.execute("create table data (id int, name varchar(25))")
    sql.executeUpdate("insert into data (id, name) values (?, ?), (?, ?)", [1, "fred", 2, "tom"])
    tableCreated = true
  }

  @Transactional
  def "delete rows from table"() {
    setup:
    sql.execute("delete from data")
  }

  @Transactional
  def "table is back to initial state"() {
    expect:
    sql.rows("select * from data order by id") == [[ID: 1, NAME: "fred"], [ID: 2, NAME: "tom"]]
  }
}

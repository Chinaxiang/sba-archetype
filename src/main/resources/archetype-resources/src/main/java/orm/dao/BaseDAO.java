#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.orm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ${package}.orm.entity.BaseDO;

/**
 * 
 * @author yanxiang.huang
 */
public interface BaseDAO extends JpaRepository<BaseDO, Long> {

}

#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.orm.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import ${package}.orm.BaseEntity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "t_base")
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor
public class BaseDO extends BaseEntity {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
}

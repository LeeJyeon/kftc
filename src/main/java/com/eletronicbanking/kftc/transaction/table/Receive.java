package com.eletronicbanking.kftc.transaction.table;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@EqualsAndHashCode
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@IdClass(ComId.class)
@Table(name = "RECEIVE")
@ToString
public class Receive implements Serializable {

    @Id @Column(length = 8)
    private String date;
    @Id @Column(length = 4)
    private String comTypeCode;
    @Id @Column(length = 4)
    private String comBizCode;
    @Id
    private Long comNumber;

    private String comContext;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

}

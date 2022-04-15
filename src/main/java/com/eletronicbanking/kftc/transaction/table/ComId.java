package com.eletronicbanking.kftc.transaction.table;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ComId implements Serializable {

    public String date;
    public String comTypeCode;
    public String comBizCode;
    public Long comNumber;
}


package com.kodgemisi;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;

/**
 * @author guanzhisong
 * @date 2024/7/29
 */
@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
@SuperBuilder
public class OrderDto {
    protected Long orderId;
    protected Integer os;
    protected Integer bt;
    protected String source;
    protected Long id;
    protected Long tid;
    protected Long did;
    protected Long pid;
    protected Long eoid;
    protected String oid;
    protected String mu;
    protected Integer rtt;
    protected Integer ot;
    protected Integer st;
    protected Integer pt;
    protected Integer ct;
    protected Integer dt;
    protected Integer ps;
    protected Date pct;
    protected Date adt;
    protected String sa;
    protected String sad;
    protected String ea;
    protected String ead;
    protected Date gm;
    protected Date gmc;
    protected Long op;
    protected Long obf;
}

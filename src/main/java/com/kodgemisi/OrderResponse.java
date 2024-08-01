package com.kodgemisi;

import com.googlecode.jmapper.annotations.JMap;
import lombok.*;

import java.util.Date;

/**
 * @author guanzhisong
 * @date 2024/7/29
 */
@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Builder
public class OrderResponse {
    @JMap
    protected Long orderId;
    @JMap
    protected Integer os;
    @JMap
    protected Integer bt;
    @JMap
    protected String source;
    @JMap
    protected Long id;
    @JMap
    protected Long tid;
    @JMap
    protected Long did;
    @JMap
    protected Long pid;
    @JMap
    protected Long eoid;
    @JMap
    protected String oid;
    @JMap
    protected String mu;
    @JMap
    protected Integer rtt;
    @JMap
    protected Integer ot;
    @JMap
    protected Integer st;
    @JMap
    protected Integer pt;
    @JMap
    protected Integer ct;
    @JMap
    protected Integer dt;
    @JMap
    protected Integer ps;
    @JMap
    protected Date pct;
    @JMap
    protected Date adt;
    @JMap
    protected String sa;
    @JMap
    protected String sad;
    @JMap
    protected String ea;
    @JMap
    protected String ead;
    @JMap
    protected Date gm;
    @JMap
    protected Date gmc;
    @JMap
    protected Long op;
    @JMap
    protected Long obf;
}

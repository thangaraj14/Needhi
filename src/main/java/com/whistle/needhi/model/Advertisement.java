package com.whistle.needhi.model;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author i312458
 */
public class Advertisement {


    @Id
    @Column(name = "id", nullable = false)
    String id;

    @Column(name = "format", nullable = false)
    String format;
}

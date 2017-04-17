package com.springcachetest.bean;


import lombok.*;

/**
 * @author 杨志远[of2551]
 *         company qianmi.com
 *         Date    2017-03-14
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person {
    private Integer id;
    private String name;
    private String sex;
    private Long sid;


}

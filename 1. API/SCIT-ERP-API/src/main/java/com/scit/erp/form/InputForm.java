package com.scit.erp.form;

import lombok.Data;

/**
 * @author kangjy
 * Input Object
 */
@Data
public class InputForm {
	/** 로그인 처리 후 보존되어있는 토큰*/
	private String token;
	/** 각API의 데이터 */
	private Object data;
}

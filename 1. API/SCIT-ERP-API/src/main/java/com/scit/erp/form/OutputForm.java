package com.scit.erp.form;

import com.scit.erp.common.CommonConstants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author kangjy
 *　Output Parameter Object
 */
@Builder
@Data
@AllArgsConstructor
public class OutputForm {
	/** status：처리결과 / 200：정상、500：에러 */
	private int status;
	/** 에러 내용 메시지 */
	private String message;
	/** 각API의 데이터 */
	private Object data;
	
	public OutputForm() {
		status = CommonConstants.STATUS_SUCCESS;
	}
}

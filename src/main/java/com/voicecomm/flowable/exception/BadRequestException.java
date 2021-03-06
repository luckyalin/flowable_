package com.voicecomm.flowable.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

/**
 * 统一异常处理
 * @author yulin.li
 */
@Getter
public class BadRequestException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1673015889176067863L;
	private Integer status = BAD_REQUEST.value();

	public BadRequestException(String msg) {
		super(msg);
	}

	public BadRequestException(HttpStatus status, String msg) {
		super(msg);
		this.status = status.value();
	}

	/**
	 * 重写fillInStackTrace方法，使其不打印出堆栈的全部信息。
	 */
	@Override
	public Throwable fillInStackTrace() {
		return this;
	}
}
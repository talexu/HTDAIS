package com.talexu.htdais.service.processor;

import com.talexu.htdais.domain.QuantizedNews;

public interface NewsProcessor {

	public void execute(QuantizedNews quantizedNews);
}

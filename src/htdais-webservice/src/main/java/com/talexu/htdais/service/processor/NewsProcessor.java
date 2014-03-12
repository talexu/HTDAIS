package com.talexu.htdais.service.processor;

import com.talexu.htdais.domain.QuantizedNews;

public interface NewsProcessor {

	public QuantizedNews execute(QuantizedNews quantizedNews);
}

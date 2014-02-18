package com.talexu.htdais_demo_cx_extractor;

public class TextExtractorDecoratorFormat extends TextExtractorDecorator {

	public TextExtractorDecoratorFormat(TextExtractor textExtractor) {
		super(textExtractor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getText() {
		return _textExtractor.getText().replaceAll("\\s+", "\n").trim();
	}
}

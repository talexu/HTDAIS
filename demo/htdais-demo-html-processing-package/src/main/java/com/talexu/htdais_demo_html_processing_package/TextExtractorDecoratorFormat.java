package com.talexu.htdais_demo_html_processing_package;

public class TextExtractorDecoratorFormat extends TextExtractorDecorator {

	public TextExtractorDecoratorFormat(TextExtractor textExtractor) {
		super(textExtractor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getText() {
		return super.getText().replaceAll("\\s+", "\n").trim();
	}
}

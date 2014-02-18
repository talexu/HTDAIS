package com.talexu.htdais_demo_cx_extractor;

public abstract class TextExtractorDecorator extends TextExtractor {

	protected TextExtractor _textExtractor;

	public TextExtractorDecorator(TextExtractor textExtractor) {
		super();
		_textExtractor = textExtractor;
	}

	@Override
	public void extractHTML(String htmlText) {
		_textExtractor.extractHTML(htmlText);
	}

	/**
	 * Gets the title.
	 * 
	 * @return the title
	 */
	@Override
	public String getTitle() {
		return _textExtractor.getTitle();
	}

	/**
	 * Gets the text.
	 * 
	 * @return the text
	 */
	@Override
	public String getText() {
		return _textExtractor.getText();
	}
}

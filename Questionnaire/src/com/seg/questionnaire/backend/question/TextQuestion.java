package com.seg.questionnaire.backend.question;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;

import com.seg.questionnaire.backend.answer.SingleAnswer;

/**
 * Class defining Free Text Question.
 * 
 * @author Marek Matejka
 *
 */
public class TextQuestion extends Question
{
	/**
	 * EditText for the answer.
	 */
	private EditText et;
	
	/**
	 * Constructor of the TextQuestion.
	 * 
	 * @param id Question's unique ID.
	 * @param question Question text.
	 * @param required Flag defining whether the question
	 * is required or not.
	 */
	public TextQuestion(String id, String question, boolean required)
	{
		super(id, question, required);
		this.answer = new SingleAnswer(id);
	}

	/* (non-Javadoc)
	 * @see com.seg.questionnaire.backend.question.Question#getView(android.content.Context)
	 */
	@Override
	public View getView(final Context context) 
	{	
		//Initialize and prepare EditText
		et = new EditText(context);
		et.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 
											ViewGroup.LayoutParams.WRAP_CONTENT));
		et.requestFocus();
		
		return et;//return the EditText
	}

	/* (non-Javadoc)
	 * @see com.seg.questionnaire.backend.question.Question#readAnswer()
	 */
	@Override
	protected void readAnswer() 
	{
		this.answer.addAnswer(et.getText().toString());
	}

	/* (non-Javadoc)
	 * @see com.seg.questionnaire.backend.question.Question#isAnswered()
	 */
	@Override
	public boolean isAnswerReady() 
	{
		if (!et.getText().toString().trim().equals(""))
			return true;
		return false;
	}

	/* (non-Javadoc)
	 * @see com.seg.questionnaire.backend.question.Question#loadAnswer()
	 */
	@Override
	public void loadAnswer() 
	{
		et.setText(answer.getAnswer());
	}

}

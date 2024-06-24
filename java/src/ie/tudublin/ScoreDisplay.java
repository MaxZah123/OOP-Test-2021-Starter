package ie.tudublin;

import java.util.ArrayList;


import processing.core.PApplet;

public class ScoreDisplay extends PApplet
{
	String score = "DEFGABcd";
	ArrayList<Note> notes;

	final int NUM = 5;
	// String score = "D2E2F2G2A2B2c2d2";
	// String score = "DEF2F2F2EFA2A2B2AFD2E2D2D2D2";

	public void settings()
	{
		size(600, 300);

		// How to convert a character to a number
		char c = '7'; // c holds the character 7 (55)
		int i = c - '0'; // i holds the number 7 (55 - 48)
		println(i);
	}
	public void setup()
	{
		notes = new ArrayList<Note>();
		loadNotes();
		printScores();
	}
	public void draw()
	{
		background(255);
		drawStaveLines();
		drawNotes();
	}
	void loadNotes()
	{
		for (int i = 0; i < score.length(); i++)
		{
			char currentNote = score.charAt(i);
			int currentDuration = 1;

			if (i + 1 != score.length())
			{
				char nextChar = score.charAt(i + 1);
				if (Character.isDigit(nextChar)) {
					currentDuration = nextChar - '0';
					i++;
				}
			}

			Note note = new Note(this, currentNote, currentDuration);
			notes.add(note);
		}
	}
	void printScores()
	{
		for (Note note : notes)
		{
			println(note.getNote() + "\t" + note.getDuration() + "\t" + (note.getDuration() == 1 ? "Quaver" : "Crotchet"));
		}
	}
	void drawStaveLines()
	{
		strokeWeight(3);
		int verticalGap = height / (NUM + 2);
		for (int i = 0; i < NUM; i++)
		{
			float yPos = (float) (i * verticalGap) + verticalGap;
			line(0.007f * width, yPos + verticalGap / 2, 0.8f * width, yPos + verticalGap / 2);
		}
	}
	void drawNotes()
	{
		line(50, 150, 50, 250);
		ellipse(40, 260, 30, 30 );

		line(100, 125, 100, 225);
		ellipse(90, 230, 30, 30 );

		line(150, 100, 150, 200);
		ellipse(140, 200, 30, 30 );

		line(200, 150, 200, 250);
		ellipse(190, 260, 30, 30 );

		line(250, 125, 250, 225);
		ellipse(240, 230, 30, 30 );

		line(300, 100, 300, 200);
		fill(0,0,0);
		ellipse(290, 200, 30, 30 );

		line(350, 75, 350, 175);
		ellipse(340, 170, 30, 30 );

		line(400, 50, 400, 150);
		ellipse(390, 140, 30, 30 );

		line(450, 50, 450, 150);
		ellipse(440, 140, 30, 30 );

		line(50, 150, 50, 250);
		ellipse(340, 170, 30, 30 );

		line(40, 30, 40, 20);

	}

}
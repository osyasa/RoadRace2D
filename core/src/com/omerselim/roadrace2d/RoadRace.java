package com.omerselim.roadrace2d;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

import java.util.Random;

public class RoadRace extends ApplicationAdapter {

	SpriteBatch batch;

	Random random;

	BitmapFont font;

	Rectangle racecarRectangle;
	Rectangle[] enemyRectangle;
	Rectangle[] enemyRectangle2;
	Rectangle[] enemyRectangle3;
	Rectangle[] enemyRectangle4;


	Texture road;
	Texture road2;
	float[] roadY;

	Texture racecar;

	Texture enemycar;
	Texture enemycar2;
	Texture enemycar3;
	Texture enemycar4;
	float[] enemycarY;
	float[] enemycar2Y;
	float[] enemycar3Y;
	float[] enemycar4Y;
	float[] enemycarX;
	float[] enemycar2X;
	float[] enemycar3X;
	float[] enemycar4X;


	float racecarX = 0;

	int gameState = 0;

	float maxX, lowX;


	@Override
	public void create() {

		batch = new SpriteBatch();

		random = new Random();

		racecarRectangle = new Rectangle();
		racecarRectangle = new Rectangle();
		enemyRectangle = new Rectangle[1];
		enemyRectangle2 = new Rectangle[1];
		enemyRectangle3 = new Rectangle[1];
		enemyRectangle4 = new Rectangle[1];


		road = new Texture("road.png");
		road2 = new Texture("road.png");
		racecar = new Texture("racecar.png");
		enemycar = new Texture("enemycar2.png");
		enemycar2 = new Texture("enemycar2.png");
		enemycar3 = new Texture("enemycar2.png");
		enemycar4 = new Texture("enemycar2.png");

		font = new BitmapFont();
		font.setColor(Color.WHITE);
		font.getData().setScale(4);

		enemycarY = new float[1];
		enemycarY[0] = random.nextFloat() * 2 * Gdx.graphics.getHeight() + Gdx.graphics.getHeight() / 3;

		enemycar2Y = new float[1];
		enemycar2Y[0] = random.nextFloat() * 2 * Gdx.graphics.getHeight() + Gdx.graphics.getHeight() / 2;

		enemycar3Y = new float[1];
		enemycar3Y[0] = random.nextFloat() * 2 * Gdx.graphics.getHeight() + Gdx.graphics.getHeight() / 1.5f;

		enemycar4Y = new float[1];
		enemycar4Y[0] = random.nextFloat() * 2 * Gdx.graphics.getHeight() + Gdx.graphics.getHeight() / 1.3f;

		enemycarX = new float[1];
		enemycarX[0] = random.nextFloat() * Gdx.graphics.getWidth();

		enemycar2X = new float[1];
		enemycar2X[0] = random.nextFloat() * Gdx.graphics.getWidth();

		enemycar3X = new float[1];
		enemycar3X[0] = random.nextFloat() * Gdx.graphics.getWidth();

		enemycar4X = new float[1];
		enemycar4X[0] = random.nextFloat() * Gdx.graphics.getWidth();


		enemyRectangle[0] = new Rectangle();
		enemyRectangle2[0] = new Rectangle();
		enemyRectangle3[0] = new Rectangle();
		enemyRectangle4[0] = new Rectangle();


		roadY = new float[2];
		roadY[0] = 0;
		roadY[1] = Gdx.graphics.getHeight();


		racecarX = Gdx.graphics.getWidth() / 2 - Gdx.graphics.getWidth() / 16;

		maxX = Gdx.graphics.getWidth() - Gdx.graphics.getWidth() / 8;
		lowX = 0;

	}

	@Override
	public void render() {

		batch.begin();

		for (int i = 0; i < 2; i++) {

			roadY[i] = roadY[i] - 10;

			if (roadY[i] < -Gdx.graphics.getHeight()) {
				roadY[i] = Gdx.graphics.getHeight();
			}
			batch.draw(road, 0, roadY[i], Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
			batch.draw(road2, 0, roadY[i], Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		}

		batch.draw(racecar, racecarX, Gdx.graphics.getHeight() / 10, Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() / 8);

		if (gameState == 1) {


			for (int i = 0; i < 1; i++) {

				enemycarY[i] = enemycarY[i] - 15;
				enemycar2Y[i] = enemycar2Y[i] - 15;
				enemycar3Y[i] = enemycar3Y[i] - 15;
				enemycar4Y[i] = enemycar4Y[i] - 15;

				if (enemycarY[i] < -Gdx.graphics.getHeight() / 8) {
					enemycarY[i] = Gdx.graphics.getHeight();
					enemycarX[i] = random.nextFloat() * Gdx.graphics.getWidth();
				}
				if (enemycar2Y[i] < -Gdx.graphics.getHeight() / 8) {
					enemycar2Y[i] = Gdx.graphics.getHeight();
					enemycar2X[i] = random.nextFloat() * Gdx.graphics.getWidth();
				}
				if (enemycar3Y[i] < -Gdx.graphics.getHeight() / 8) {
					enemycar3Y[i] = Gdx.graphics.getHeight();
					enemycar3X[i] = random.nextFloat() * Gdx.graphics.getWidth();
				}
				if (enemycar4Y[i] < -Gdx.graphics.getHeight() / 8) {
					enemycar4Y[i] = Gdx.graphics.getHeight();
					enemycar4X[i] = random.nextFloat() * Gdx.graphics.getWidth();
				}

				batch.draw(enemycar, enemycarX[i], enemycarY[i], Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() / 8);
				batch.draw(enemycar2, enemycar2X[i], enemycar2Y[i], Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() / 8);
				batch.draw(enemycar3, enemycar3X[i], enemycar3Y[i], Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() / 8);
				batch.draw(enemycar4, enemycar4X[i], enemycar4Y[i], Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() / 8);

				enemyRectangle[i] = new Rectangle(enemycarX[i], enemycarY[i], Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() / 8);
				enemyRectangle2[i] = new Rectangle(enemycar2X[i], enemycar2Y[i], Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() / 8);
				enemyRectangle3[i] = new Rectangle(enemycar3X[i], enemycar3Y[i], Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() / 8);
				enemyRectangle4[i] = new Rectangle(enemycar4X[i], enemycar4Y[i], Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() / 8);


			}


			if (Gdx.input.isTouched()) {
				if (Gdx.input.getX() > Gdx.graphics.getWidth() / 2) {
					if (racecarX < maxX) {
						racecarX += 20;
					}
				}
				if (Gdx.input.getX() < Gdx.graphics.getWidth() / 2) {
					if (racecarX > lowX) {
						racecarX -= 20;
					}
				}
			}
		} else if (gameState == 0) {
			if (Gdx.input.justTouched()) {
				gameState = 1;
			}
		} else if (gameState == 2) {

			font.draw(batch, "tap to play again", 340, Gdx.graphics.getHeight()/2);

			if (Gdx.input.justTouched()) {
				gameState = 1;


				batch.draw(racecar, racecarX, Gdx.graphics.getHeight() / 10, Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() / 8);

				enemyRectangle[0] = new Rectangle();
				enemyRectangle2[0] = new Rectangle();
				enemyRectangle3[0] = new Rectangle();
				enemyRectangle4[0] = new Rectangle();

				enemycarY = new float[1];
				enemycarY[0] = random.nextFloat() * 2 * Gdx.graphics.getHeight() + Gdx.graphics.getHeight() / 3;

				enemycar2Y = new float[1];
				enemycar2Y[0] = random.nextFloat() * 2 * Gdx.graphics.getHeight() + Gdx.graphics.getHeight() / 2;

				enemycar3Y = new float[1];
				enemycar3Y[0] = random.nextFloat() * 2 * Gdx.graphics.getHeight() + Gdx.graphics.getHeight() / 1.5f;

				enemycar4Y = new float[1];
				enemycar4Y[0] = random.nextFloat() * 2 * Gdx.graphics.getHeight() + Gdx.graphics.getHeight() / 1.3f;

				enemycarX = new float[1];
				enemycarX[0] = random.nextFloat() * Gdx.graphics.getWidth();

				enemycar2X = new float[1];
				enemycar2X[0] = random.nextFloat() * Gdx.graphics.getWidth();

				enemycar3X = new float[1];
				enemycar3X[0] = random.nextFloat() * Gdx.graphics.getWidth();

				enemycar4X = new float[1];
				enemycar4X[0] = random.nextFloat() * Gdx.graphics.getWidth();
			}
		}


			batch.end();
			racecarRectangle.set(racecarX, Gdx.graphics.getHeight() / 10, Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() / 8);


			for (int i = 0; i < 1; i++) {

				if (Intersector.overlaps(racecarRectangle, enemyRectangle[i]) || Intersector.overlaps(racecarRectangle, enemyRectangle2[i]) || Intersector.overlaps(racecarRectangle, enemyRectangle3[i]) || Intersector.overlaps(racecarRectangle, enemyRectangle4[i])) {
					gameState = 2;
				}
			}


		}

		@Override
		public void dispose () {

		}
	}


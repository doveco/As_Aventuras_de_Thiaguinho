package com.goforward.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Menu {

	public String[] options = {"novo jogo","carregar jogo","sair"};
	
	public int currentOption = 0;
	public int maxOption = options.length - 1;
	
	public boolean up, down, enter;
	
	public boolean pause = false; 
	
	public void tick() {
		if(up) {
			up = false;
			currentOption--;
			if(currentOption < 0) {
				currentOption = maxOption;
			}
		}
		if(down) {
			down = false;
			currentOption++;
			if(currentOption > maxOption) {
				currentOption = 0;
			}
		}
		if(enter) {
			enter = false;
			if(options[currentOption] == "novo jogo" || options[currentOption] == "continuar") {
				Game.gameState = "NORMAL";		
				pause = false;
			} else if (options[currentOption] == "sair") {
				System.exit(1);
			}
		}				
	}
	
	public void render(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(new Color(0,0,0,100));
		g2.fillRect(0, 0, Game.WIDTH*Game.SCALE, Game.HEIGHT*Game.SCALE);
		g.setColor(Color.green);
		g.setFont(new Font("arial",Font.BOLD,30));
		g.drawString("As Aventuras de Thiaguinho", (Game.WIDTH*Game.SCALE) / 2 - 200 , (Game.HEIGHT*Game.SCALE) / 2 - 200 );
		
		// Opções do menu
		g.setColor(Color.white);
		g.setFont(new Font("arial",Font.BOLD,20));
		if(pause == false) {
			g.drawString("NOVO JOGO", (Game.WIDTH*Game.SCALE) / 2 - 70 , (Game.HEIGHT*Game.SCALE) / 2 - 100 );		
		} else {
			g.drawString("RESUMIR", (Game.WIDTH*Game.SCALE) / 2 - 50 , (Game.HEIGHT*Game.SCALE) / 2 - 100 );
		}
		g.drawString("CARREGAR JOGO", (Game.WIDTH*Game.SCALE) / 2 - 100 , (Game.HEIGHT*Game.SCALE) / 2 - 70 );
		g.drawString("SAIR", (Game.WIDTH*Game.SCALE) / 2 - 30 , (Game.HEIGHT*Game.SCALE) / 2 - 40 );
		
		if (options[currentOption] == "novo jogo") {
			g.drawString(">", (Game.WIDTH*Game.SCALE) / 2 - 90 , (Game.HEIGHT*Game.SCALE) / 2 - 100 );
		} else if (options[currentOption] == "carregar jogo") {
			g.drawString(">", (Game.WIDTH*Game.SCALE) / 2 - 120 , (Game.HEIGHT*Game.SCALE) / 2 - 70 );
		} else if (options[currentOption] == "sair") {
			g.drawString(">", (Game.WIDTH*Game.SCALE) / 2 - 50 , (Game.HEIGHT*Game.SCALE) / 2 - 40 );		
		}
	
	}
	
}

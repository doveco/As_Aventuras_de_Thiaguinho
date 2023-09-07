package com.goforward.graficos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.goforward.entities.Player;
import com.goforward.main.Game;

public class Ui {

	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(8, 4,50, 8);
		g.setColor(Color.green);
		g.fillRect(8, 4,(int)((Game.player.life/Game.player.maxlife)*50), 8);
		g.setColor(Color.white);
		g.setFont(new Font("arial",Font.BOLD,8));
		g.drawString((int)Game.player.maxlife+"/"+(int)Game.player.life,19,11);
	}
	
}

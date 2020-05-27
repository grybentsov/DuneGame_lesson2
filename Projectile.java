package com.dune.game.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Projectile {
    private Vector2 position;
    private Vector2 velocity;
    public TextureRegion texture;
    private Tank tank;

    public Projectile(TextureAtlas atlas, Vector2 position){
        this.position = new Vector2();
        this.texture = new TextureRegion(atlas.findRegion("bullet"));
        this.velocity = velocity;
        this.tank = tank;
    }

    public Vector2 getPosition(){
        return position;
    }

    public Vector2 getVelocity(){
        return velocity;
    }

    public void setup(Vector2 startPosition, float angle) {
        velocity.set(100.0f * MathUtils.cosDeg(angle), 0.0f);
    }

    public void update(float dt) {
//         position.x += velocity.x * dt;
//         position.y += velocity.y * dt;
        position.mulAdd(velocity, dt);
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y);
    }

    public void checkBounds(float dt){
        if (position.x < 0 || position.x > 1240){
            setup(tank.getPosition(), tank.getAngle());
            update(dt);
        }
        if (position.y < 0 || position.y > 720){
            setup(tank.getPosition(), tank.getAngle());
            update(dt);
        }
    }
}


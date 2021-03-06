package var3d.net.demo;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;

import var3d.net.center.DialogMessge;
import var3d.net.center.VGame;
import var3d.net.center.VLabel;
import var3d.net.center.VStage;

/**
 * Created by fengyu on 16/4/8.
 */
public class StageTest extends VStage {
    private VLabel txt_logo;
    private Button btn_tost, btn_dialog;

    public StageTest(VGame game) {
        super(game);
        game.loadFolderToPack(R.image.class);
    }

    @Override
    public void init() {
        //setBackground(R.image.bg);//设置背景
        setBackground(Color.DARK_GRAY);//设置背景
        //设置标题
        txt_logo = game.getLabel(R.strings.logo).setColor(Color.BLUE).setStroke(Color.CYAN)
                .setPosition(getWidth() / 2, getHeight() / 2f, Align.center).setAlpha(0.9f).touchOff().show();
        //Tost
        // Gdx.app.log("aaaaaa", "cutWidth=" + getCutWidth() + "*" + getCutHeight());
        btn_tost = game.getButton(R.image.pause_btn_bg).setPosition(getWidth() / 2, getTop(), Align.top).addClicAction().show();
        btn_tost.add(game.getLabel(R.strings.tost).getActor());
        btn_tost.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                game.setUserData(DialogMessge.MODEL, new DialogMessge.Model("这是一个Tost范例"));
                game.showDialog(DialogMessge.class);
            }
        });

        //自定义对话框
        btn_dialog = game.getButton(R.image.pause_btn_bg).setPosition(getWidth() / 2
                , getBottom(), Align.bottom).addClicAction().show();
        btn_dialog.add(game.getLabel(R.strings.dialogTitle).getActor());
        btn_dialog.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                game.showDialog(DialogTest.class);
            }
        });

        Image left = game.getImage(50, 50).setPosition(getLeft(), getHeight() / 2, Align.left).show();
        Image right = game.getImage(50, 50).setPosition(getRight(), getHeight() / 2, Align.right).show();

        Image testTopRight = game.getImage(50, 50, Color.RED)
                .setPosition(getRight(), getTop(), Align.topRight).show();

        //shader测试
//        WaterActor waterActor = game.getUI(new WaterActor(game.getTextureRegion(R.image.badlogic))).show(Align.center);
//        OutLineActor outLineActor = game.getUI(new OutLineActor(game.getTextureRegion(R.image.tank_4)))
//                .setPosition(getWidth() / 2, waterActor.getY() - 10, Align.top).show();
    }

    @Override
    public void reStart() {

    }

    @Override
    public void back() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void changing(float width, float height) {
    }
}

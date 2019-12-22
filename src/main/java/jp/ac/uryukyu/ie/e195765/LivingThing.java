package jp.ac.uryukyu.ie.e195765;

public class LivingThing {
    private String name;
    /**
     * hero,enemyの名前を受け取るメソッド。
     *
     * @return String name hero,enemyの名前。
     */
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    private int hitPoint;
    /**
     * hero,enemyのHP(体力)を受け取るメソッド
     *
     * @return int hitpoint hero,enemyの体力
     */
    public int getHitPoint() {
        return hitPoint;
    }

    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }

    private int attack;
    /**
     * hero,enemyのAttack(攻撃力)を受け取るメソッド
     *
     * @return int attack hero,enemyの攻撃力
     */
    public int getAttack(){
        return attack;
    }
    public void setAttack(int attack){
        this.attack = attack;
    }

    private boolean dead;
    /**
     * hero,enemyが生きている(false)か死んでいる(True)かを受け取るメソッド。
     *
     * @return boolean dead hero,enemyの生死
     */
    public boolean getdead() {

        return dead;
    }
    public void setDead(boolean dead) {

        this.dead = dead;
    }


    /**
     * 生きている状態:dead = false
     * @param name Hero,enemyの名前
     * @param maximumHP　Hero,enemyのHP
     * @param attack　Hero,enemyの攻撃力
     */

    public LivingThing(String name, int maximumHP, int attack){
        dead = false;
        this.name = name;
        this.hitPoint = maximumHP;
        this.attack = attack;
    }
    /**
     * hero,enemyが生きているか死んでいるか決めるメソッド。
     * @return boolean
     */
    public boolean isDead(){
        return dead;
    }

    /**
     * 攻撃するメソッド。
     * attackに応じて乱数でダメージを算出し、name.wounded()によりダメージ処理を実行。
     * @param opponent 攻撃対象
     */
    public void attack(LivingThing opponent) {
        if (dead == false) {
            int damage = (int) (Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            opponent.wounded(damage);
        }
    }
    /**
     * attackで確定したダメージをHPから減らす処理を行うメソッド。
     *
     * @param damage 受けるダメージ
     */
    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint < 0 ) {
            dead = true;
            System.out.printf("%sは倒れた。\n", name);
        }

    }
}


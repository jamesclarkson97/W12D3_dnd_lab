package behaviours;

import weapon.WeaponType;

public interface Melee {
    public String fight();
    public void changeWeapon(WeaponType weapon);
    public void doDamage();
}

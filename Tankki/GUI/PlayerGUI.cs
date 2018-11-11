using UnityEngine;
using UnityEngine.UI;

namespace GameProgramming3D.GUI
{
    public class PlayerGUI : MonoBehaviour
    {
        private HealthBar _healthBar;
        public Player AssociatedPlayer { get; private set; }
        private int playerHealth;
        public Unit[] unitsToShow;
        private Text text;

        public void Init(Player _player,  Unit[] units)
        {
            text = GetComponentInChildren<Text>();
            AssociatedPlayer = _player;
            for (int i = 0; i < units.Length; i++) {
                units[i] = _player.GetUnitById(i);
            }
            _healthBar = GetComponentInChildren<HealthBar>();
            foreach (Unit unit in units)
            {
                playerHealth += unit.Health;
                unit.DamageTaken += HandleDamageTaken;
            }
            _healthBar.Init(playerHealth);
            unitsToShow = units;
            text.text = AssociatedPlayer.gameObject.name;
        }

        public void HandleDamageTaken(int health)
        {
            int tempHealth = 0;
            foreach (Unit unit in unitsToShow)
            {
                tempHealth += unit.Health;
            }
            _healthBar.SetHealth(tempHealth);
        }
    }
}

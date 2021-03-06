using UnityEngine;
using System.Collections.Generic;
using GameProgramming3D.GUI;

namespace GameProgramming3D
{
	public class Player : MonoBehaviour
	{
		private Unit[] _units;
		private int _unitIndex = -1;

        protected PlayerGUI GUI { get; set; }
        public GameObject playerInfo;

		[SerializeField] private int _id;

		public int Id { get { return _id; } }

		public Unit UnitInTurn
		{
			get
			{
				return _unitIndex >= 0 &&
					_unitIndex < _units.Length ? _units[_unitIndex] : null;
			}
		}

		public void Init()
		{
			_units = GetComponentsInChildren<Unit> ();
			for(int i = 0; i < _units.Length; i++ )
			{
				_units[i].Init ( this );
			}

			if ( !CheckUnitIds() )
			{
				Debug.LogError( 
					string.Format( "Player {0}: There are invalid unit ids!", Id ) );
				Debug.Break();
			}
            GUI = playerInfo.GetComponent<PlayerGUI>();
            GUI.Init(this, _units);
		}

		private bool CheckUnitIds()
		{
			HashSet<int> unitIds = new HashSet< int >();
			foreach ( Unit unit in _units )
			{
				if ( !unitIds.Add( unit.Id ) )
				{
					return false;
				}
			}

			return true;
		}
	
		public void StartTurn()
		{
			_unitIndex++;
			if(_unitIndex >= _units.Length)
			{
				_unitIndex = 0;
			}
			GameManager.Instance.SelectedUnit = UnitInTurn;
		}

		public void UnitKilled ()
		{
			bool anyUnitsAlive = false;
			foreach ( var unit in _units )
			{
				if ( unit.IsAlive )
				{
					anyUnitsAlive = true;
				}
			}

			if ( !anyUnitsAlive )
			{
				GameManager.Instance.PlayerLost();
			}
		}

		public void SetActiveUnit(int unitId)
		{
			_unitIndex = GetUnitIndex ( unitId );
		}

		private int GetUnitIndex(int unitId)
		{
			Unit unit = GetUnitById ( unitId );
			if(unit == null)
			{
				return -1;
			}
			return System.Array.IndexOf ( _units, unit );
		}

		public Unit GetUnitById(int unitId)
		{
			Unit unit = null;
			foreach (Unit u in _units)
			{
				if(u.Id == unitId)
				{
					unit = u;
				}
			}

			return unit;
		}
	}
}

using UnityEngine;
using System.Collections;
using System.Collections.Generic;

namespace GameProgramming3D
{
	public class Projectile : MonoBehaviour
	{
		[SerializeField] private float _blastRadius;
		[SerializeField] private float _explosionDamage;
		[SerializeField] private float _explosionForce;
		[SerializeField] private GameObject _explosionEffect;

		public Rigidbody Rigidbody { get { return _rigidbody; } }

		private Rigidbody _rigidbody;
		private IShooter _shooter;

		protected void Awake()
		{
			_rigidbody = gameObject.GetOrAddComponent<Rigidbody> ();
		}

		public void Shoot(Vector3 force, IShooter shooter)
		{
			_shooter = shooter;
			gameObject.SetActive ( true );
			_rigidbody.AddForce ( force, ForceMode.Impulse );
		}

		protected void OnCollisionEnter(Collision other)
		{
			Explode ();
		}
		
		private void Explode()
		{
			ApplyDamage ();
			InstantiateEffect ();
			_shooter.ProjectileHit( this );
		}

		private void InstantiateEffect()
		{
			var position = transform.position;
			position.y += 0.1f;
			var effect = Instantiate ( _explosionEffect,
				position, Quaternion.identity ) as GameObject;
			var effectDuration = 0f;
			var effects =
				effect.GetComponentsInChildren<ParticleSystem> ( true );

			foreach(var e in effects)
			{
				effectDuration = Mathf.Max ( effectDuration, e.duration );
			}

			Destroy ( effect, effectDuration );
		}

		private void ApplyDamage()
		{
            List<GameObject> objs = new List<GameObject>();

            var damageReceivers = 
				Physics.OverlapSphere ( transform.position, _blastRadius );

			for (int i = 0; i < damageReceivers.Length; ++i )
			{
                var damageReceiver =
                    damageReceivers[i].GetComponent<IDamageReceiver>();

				if(damageReceiver != null && !objs.Contains(damageReceivers[i].gameObject))
				{
                    objs.Add(damageReceivers[i].gameObject);

                    damageReceiver.TakeDamage ( _explosionDamage );
					damageReceiver.ApplyExplosionForce ( _explosionForce,
						transform.position, _blastRadius );
				}
			}
		}
	}
}

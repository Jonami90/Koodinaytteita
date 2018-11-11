using UnityEngine;
using System.Collections;

public class ShakeCamera : MonoBehaviour {

	private float duration;
	private float speed;
	private float magnitude;
	private bool test;

	// Use this for initialization
	void Start () {
//		duration = 0.3f;
//		speed = 6.0f;
//		magnitude = 1.2f;
		test = false;
	}

	public void SetValues(float dur, float spd, float mag) {
		duration = dur;
		speed = spd;
		magnitude = mag;
	}

	public void PlayShake() {
		StopAllCoroutines ();
		StartCoroutine ("Shake");
	}

	// Update is called once per frame
	void Update () {
		if (test) {
			test = false;
			PlayShake ();
		}
	}

	IEnumerator Shake() {
		float elapsed = 0.0f;
		Vector3 originalCamPos = transform.position;
		float randomStart = Random.Range (-1000.0f, 1000.0f);

		while (elapsed < duration) {
			elapsed += Time.deltaTime;

			float percenComplete = elapsed / duration;
			float damper = 1.0f - Mathf.Clamp (2.0f * percenComplete - 1.0f, 0.0f, 1.0f);
			float alpha = randomStart + speed * percenComplete;

			float x = Mathf.PerlinNoise (alpha * 2.0f - 1.0f, 0.0f) * 2 - 1;
			float y = Mathf.PerlinNoise (0.0f, alpha * 2.0f - 1.0f) * 2 - 1;

			x *= magnitude * damper;
			y *= magnitude * damper;

			transform.position = new Vector3 (x, y, transform.position.z);

			yield return null;
		}

		transform.position = originalCamPos;
	}
}

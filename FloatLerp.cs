using UnityEngine;
using System.Collections;

public class FloatLerp : MonoBehaviour {
	float lerpStart;
	float lerpEnd;
	float lerpTime;
	float lerpSpd;
	bool started = false;
	public float value;
	// Update is called once per frame
	void Update () {
		if (started) {
			if (lerpTime <= 1) {
				lerpTime += Time.deltaTime * lerpSpd;
				value = Mathf.Lerp (lerpStart, lerpEnd, lerpTime);
			} else {
				GameObject.Destroy (this, 1);
			}
		}
	}

	public void StartLerp(float start, float end, float spd){
		lerpStart = start;
		lerpEnd = end;
		lerpSpd = spd;
		started = true;
		value = lerpStart;
		lerpTime = 0;
	}
}

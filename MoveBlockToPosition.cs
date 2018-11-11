using UnityEngine;
using System.Collections;

public class MoveBlockToPosition : MonoBehaviour {

    private Vector3 original;
    private Vector3 distant;
    private Vector3 passed;

    private float speed;
    private float startTime;
    private float journeyLength;
    private float journeyLengthTwo;
    [SerializeField]
    private float ease;
    [SerializeField]
    private float easeTimer;
    private float easeSpeed;
    [SerializeField]
    private float nstart;
    [SerializeField]
    private bool wentPast;

    // Use this for initialization
    void Start () {
        original = transform.position;
        distant = transform.position + new Vector3(0, 0, 15);
        passed = transform.position + new Vector3(0, 0, -1);
        transform.position = distant;

        startTime = Time.time;
        journeyLength = Vector3.Distance(distant, original);
        journeyLengthTwo = Vector3.Distance(passed, original);
        speed = 3.5f * Random.Range(0.85f, 1.25f);
        easeTimer = 0.25f;
        easeSpeed = 0.3f;
        ease = 0.0f;

        nstart = 0.0f;

        wentPast = false;
    }
	
	// Update is called once per frame
	void Update () {
        if (easeTimer < 1.25f)
        {
            easeTimer += Time.deltaTime * easeSpeed;
            ease = Mathf.Lerp(0.2f, 2.0f, easeTimer);
        }

        float distCovered = (Time.time - startTime) * (speed * ease);
        float fracJourney = distCovered / journeyLength;
        transform.position = Vector3.Lerp(distant, passed, fracJourney);

        if (transform.position == passed && wentPast == false)
        {
            wentPast = true;
            easeTimer = 0.8f;
            ease = 0.0f;
            distCovered = 0.0f;
            fracJourney = 0.0f;
        }

        if (wentPast == true)
        {
            startTime = 0.0f;
            if (easeTimer < 1)
            {
                easeTimer += Time.deltaTime * easeSpeed;
                ease = Mathf.Lerp(1f, 1.2f, easeTimer);
            }

            distCovered = (nstart - startTime) * (speed * ease);
            fracJourney = distCovered / journeyLengthTwo;
            transform.position = Vector3.Lerp(passed, original, fracJourney);

            nstart += Time.deltaTime;
        }

        if (wentPast == true && transform.position == original)
        {
            gameObject.GetComponent<MoveBlockToPosition>().enabled = false;
        }
    }
}

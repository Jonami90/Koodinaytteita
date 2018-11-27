using UnityEngine;
using System.Collections;
using UnityEngine.UI;

public class GoalImgScript : MonoBehaviour {

    private Color imgColor;
    private Image img;
    public float fadeStrength;
    public float sizeSpeed;
    private float alpha;
    private Vector3 originalSize;
    private float originalAlpha;
    public bool start;
	public Sprite oneGoal;
	public Sprite dblGoal;

    // Use this for initialization
    void Start () {
		if (oneGoal == null)
			oneGoal = GetComponent<Image> ().sprite;
        img = gameObject.GetComponent<Image>();
        imgColor = img.color;
        alpha = imgColor.a;
        originalAlpha = imgColor.a;
        originalSize = gameObject.transform.localScale;
        start = false;
        gameObject.GetComponent<Image>().enabled = false;
	}

    // Update is called once per frame
    void Update()
    {
        if (start == true)
        {
            gameObject.GetComponent<Image>().enabled = true;
            transform.localScale = transform.localScale + new Vector3(1, 1, 1) * sizeSpeed * Time.deltaTime;

            if (transform.localScale.x >= 2)
            {
                alpha = imgColor.a - Time.deltaTime * fadeStrength;
                imgColor.a = alpha;
                img.color = imgColor;
            }

            if (alpha <= 0)
            {
                ResetSizeColor();
                ResetObj();
            }
        }
    }

    public void ResetSizeColor()
    {
        transform.localScale = new Vector3(1, 1, 1);
        imgColor.a = originalAlpha;
        img.color = imgColor;
		alpha = originalAlpha;
    }

    public void ResetObj()
    {
		Debug.Log ("ResetObj - Start = false");
		gameObject.GetComponent<Image> ().sprite = oneGoal;
        start = false;
        gameObject.GetComponent<Image>().enabled = false;
    }
}

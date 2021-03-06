﻿using UnityEngine;
using System.Collections;
using System.Collections.Generic;

public class PoolerScript : MonoBehaviour {

    public static PoolerScript current;
    public GameObject pooledObject;
    public int pooledAmount = 100;
    public bool willGrow = true;

    List<GameObject> pooledObjects;

    // Use this for initialization
    void Awake()
    {
        current = this;
    }

    void Start () {
        pooledObjects = new List<GameObject>();

        for (int i = 0; i < pooledAmount; i++)
        {
            GameObject obj = (GameObject)Instantiate(pooledObject);
            obj.transform.SetParent(transform);
            obj.SetActive(false);
            pooledObjects.Add(obj);
        }
	}
	
    public GameObject GetPooledObject()
    {
        for (int i = 0; i < pooledObjects.Count; i++)
        {
            if (!pooledObjects[i].activeInHierarchy)
            {
                return pooledObjects[i];
            }
        }

        if (willGrow)
        {
            GameObject obj = (GameObject)Instantiate(pooledObject);
            pooledObjects.Add(obj);
            return obj;
        }
        return null;
    }
}

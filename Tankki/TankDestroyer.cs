﻿using UnityEngine;
using System.Collections;

namespace GameProgramming3D
{
    public class TankDestroyer : MonoBehaviour
    {
        public Rigidbody Rigidbody { get; private set; }

        public void Init()
        {
            MeshCollider meshCollider = gameObject.GetOrAddComponent<MeshCollider>();
            MeshFilter meshFilter = GetComponent<MeshFilter>();

            if (meshFilter != null)
            {
                meshCollider.sharedMesh = meshFilter.sharedMesh;
                meshCollider.convex = true;
            }

            Rigidbody = gameObject.GetOrAddComponent<Rigidbody>();
        }
    }
}
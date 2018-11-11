// Upgrade NOTE: replaced '_Object2World' with 'unity_ObjectToWorld'

Shader "Unlit/UnderwaterComplex"
{
	Properties
	{
		_MainTex("Texture", 2D) = "white" {}
		_WaterColor("WaterColor", Color) = (0,0.5,1,1)
		_Opacity("WaterOptical", Range(0,1)) = 1
	}
	SubShader 
		{
		Tags{ "RenderType" = "Opaque" }
		LOD 100
		Pass
		{
			CGPROGRAM
			#pragma vertex vert
			#pragma fragment frag
			#include "UnityCG.cginc"

			struct appdata
			{
				float4 vertex : POSITION;
				float2 uv : TEXCOORD0;
			};

			struct v2f
			{
				float2 uv : TEXCOORD0;
				float4 vertex : SV_POSITION;
				float3 worldPosition : TEXCOORD1;
			};

			sampler2D _MainTex;
			float4 _MainTex_ST;
			float _Opacity;
			fixed4 _WaterColor;

			v2f vert(appdata v)
			{
				v2f o;
				o.vertex = mul(UNITY_MATRIX_MVP, v.vertex);
				o.worldPosition = mul(unity_ObjectToWorld, v.vertex).xyz;
				o.uv = TRANSFORM_TEX(v.uv, _MainTex);
				UNITY_TRANSFER_FOG(o,o.vertex);
				return o;
			}
			fixed4 frag(v2f i) : SV_Target
			{
				// sample the texture
				fixed4 col = tex2D(_MainTex, i.uv);
				float3 cameraPos = _WorldSpaceCameraPos;
				float3 fragmentPos = i.worldPosition;
				float3 cameraToFragment = fragmentPos - cameraPos;
				float3 cameraDir = normalize(cameraToFragment);
				float dist = length(cameraToFragment);
				float waterIntersection = max(0, -cameraPos.y / cameraDir.y);
				float waterDepth = saturate((dist - waterIntersection)*_Opacity) * step(0, -cameraDir.y);
				return lerp(col, _WaterColor, waterDepth);
			}
			ENDCG
		}
	}
}
# SW-repo-template!!
## Другий
### Третій

```json
{
	"description": "Опис локацій",
	"type": "object",
	"properties": {
		"loc": {
			"description": "Опис локацій",
			"type": "object",
			"properties": {
				"lname": {
				"description": "Опис локацій"
				},
				"dept": {
					"description": "Опис локацій",
					"type": "object",
					"properties": {
						"dname": {
						"description": "Опис локацій"
						},
						"emp": {
							"description": "Опис локацій",
							"type": "object",
							"properties": {
								"ename": {
								"description": "Опис локацій"
								},
								"job": {
								"description": "Опис локацій"
								},
								"mgr": {
								"description": "Опис локацій"
								}
							},
							"required": [ "ename", "job", "mgr" ]
						}   
					},
					"required": [ "dname", "emp" ]
				}
			},
			"required": [ "lname", "dept" ]
		}
	}
}

```


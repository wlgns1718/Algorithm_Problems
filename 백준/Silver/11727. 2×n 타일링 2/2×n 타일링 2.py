import sys

input = sys.stdin.readline

ls = [0, 1, 3, 5, 11, 21, 43, 85, 171, 341, 683, 1365, 2731, 5461, 916, 1831, 3663, 7325, 4644, 9287, 8568, 7128, 4250, 8499, 6992, 3976, 7953, 5898, 1790, 3579, 7159, 4310, 8621, 7234, 4462, 8923, 7840, 5672, 1338, 2675, 5351, 694, 1389, 2777, 5555, 1102, 2205, 4409, 8819, 7630, 5254, 500, 1001, 2001, 4003, 8005, 6004, 2000, 4001, 8001, 5996, 1984, 3969, 7937, 5868, 1728, 3457, 6913, 3820, 7639, 5272, 536, 1073, 2145, 4291, 8581, 7156, 4304, 8609, 7210, 4414, 8827, 7648, 5288, 570, 1139, 2279, 4557, 9115, 8222, 6438, 2868, 5737, 1466, 2933, 5865, 1724, 3447, 6895, 3782, 7565, 5122, 238, 475, 951, 1901, 3803, 7605, 5204, 400, 801, 1601, 3203, 6405, 2804, 5607, 1208, 2415, 4831, 9661, 9316, 8624, 7242, 4476, 8953, 7898, 5790, 1572, 3145, 6289, 2572, 5143, 280, 559, 1119, 2237, 4475, 8949, 7892, 5776, 1546, 3091, 6183, 2358, 4717, 9433, 8860, 7712, 5418, 828, 1657, 3313, 6627, 3246, 6493, 2978, 5957, 1906, 3813, 7625, 5244, 480, 961, 1921, 3843, 7685, 5364, 720, 1441, 2881, 5763, 1518, 3037, 6073, 2140, 4279, 8559, 7110, 4214, 8427, 6848, 3688, 7377, 4746, 9493, 8978, 7950, 5892, 1778, 3555, 7111, 4214, 8429, 6850, 3694, 7387, 4768, 9535, 9064, 8120, 6234, 2460, 4921, 9841, 9676, 9344, 8682, 7356, 4706, 9411, 8816, 7624, 5242, 476, 953, 1905, 3811, 7621, 5236, 464, 929, 1857, 3715, 7429, 4852, 9703, 9400, 8792, 7578, 5148, 290, 579, 1159, 2317, 4635, 9269, 8532, 7056, 4106, 8211, 6416, 2824, 5649, 1290, 2581, 5161, 316, 631, 1263, 2525, 5051, 94, 189, 377, 755, 1509, 3019, 6037, 2068, 4135, 8271, 6534, 3062, 6123, 2240, 4479, 8959, 7910, 5814, 1620, 3241, 6481, 2956, 5911, 1816, 3631, 7263, 4518, 9037, 8066, 6126, 2244, 4489, 8977, 7948, 5888, 1770, 3539, 7079, 4150, 8301, 6594, 3182, 6363, 2720, 5439, 872, 1743, 3487, 6973, 3940, 7879, 5752, 1496, 2993, 5985, 1964, 3927, 7855, 5702, 1398, 2795, 5591, 1174, 2349, 4697, 9395, 8782, 7558, 5108, 210, 419, 839, 1677, 3355, 6709, 3412, 6823, 3640, 7279, 4552, 9103, 8200, 6392, 2778, 5555, 1104, 2207, 4415, 8829, 7652, 5296, 586, 1171, 2343, 4685, 9371, 8734, 7462, 4916, 9833, 9658, 9310, 8612, 7218, 4428, 8857, 7706, 5406, 804, 1609, 3217, 6435, 2862, 5725, 1442, 2885, 5769, 1532, 3063, 6127, 2246, 4493, 8985, 7964, 5920, 1834, 3667, 7335, 4662, 9325, 8642, 7278, 4548, 9097, 8186, 6366, 2724, 5449, 890, 1781, 3561, 7123, 4238, 8477, 6946, 3886, 7771, 5536, 1064, 2129, 4257, 8515, 7022, 4038, 8075, 6144, 2280, 4561, 9121, 8236, 6464, 2922, 5843, 1680, 3359, 6719, 3430, 6861, 3714, 7429, 4850, 9701, 9394, 8782, 7556, 5106, 204, 409, 817, 1635, 3269, 6539, 3070, 6141, 2274, 4549, 9097, 8188, 6368, 2730, 5459, 912, 1823, 3647, 7293, 4580, 9159, 8312, 6616, 3226, 6451, 2896, 5791, 1576, 3151, 6303, 2598, 5197, 386, 773, 1545, 3091, 6181, 2356, 4711, 9423, 8838, 7670, 5332, 658, 1315, 2631, 5261, 516, 1031, 2063, 4125, 8251, 6494, 2982, 5963, 1920, 3839, 7679, 5350, 694, 1387, 2775, 5549, 1092, 2183, 4367, 8733, 7460, 4912, 9825, 9642, 9278, 8548, 7090, 4172, 8345, 6682, 3358, 6715, 3424, 6847, 3688, 7375, 4744, 9487, 8968, 7928, 5850, 1692, 3385, 6769, 3532, 7063, 4120, 8239, 6472, 2936, 5873, 1738, 3477, 6953, 3900, 7799, 5592, 1176, 2353, 4705, 9411, 8814, 7622, 5236, 466, 931, 1863, 3725, 7451, 4894, 9789, 9570, 9134, 8260, 6514, 3020, 6041, 2074, 4149, 8297, 6588, 3168, 6337, 2666, 5333, 658, 1317, 2633, 5267, 526, 1053, 2105, 4211, 8421, 6836, 3664, 7329, 4650, 9301, 8594, 7182, 4356, 8713, 7418, 4830, 9659, 9312, 8616, 7226, 4444, 8889, 7770, 5534, 1060, 2121, 4241, 8483, 6958, 3910, 7819, 5632, 1256, 2513, 5025, 44, 87, 175, 349, 699, 1397, 2795, 5589, 1172, 2343, 4687, 9373, 8740, 7472, 4938, 9875, 9744, 9480, 8954, 7900, 5794, 1580, 3161, 6321, 2636, 5271, 536, 1071, 2143, 4285, 8571, 7134, 4262, 8523, 7040, 4072, 8145, 6282, 2558, 5115, 224, 447, 895, 1789, 3579, 7157, 4308, 8615, 7224, 4440, 8881, 7754, 5502, 996, 1993, 3985, 7971, 5934, 1862, 3723, 7447, 4886, 9773, 9538, 9070, 8132, 6258, 2508, 5017, 26, 53, 105, 211, 421, 843, 1685, 3371, 6741, 3476, 6951, 3896, 7791, 5576, 1144, 2289, 4577, 9155, 8302, 6598, 3188, 6377, 2746, 5493, 978, 1957, 3913, 7827, 5646, 1286, 2571, 5143, 278, 557, 1113, 2227, 4453, 8907, 7806, 5606, 1204, 2409, 4817, 9635, 9262, 8518, 7028, 4050, 8099, 6192, 2376, 4753, 9505, 9004, 8000, 5994, 1980, 3961, 7921, 5836, 1664, 3329, 6657, 3308, 6615, 3224, 6447, 2888, 5775, 1544, 3087, 6175, 2342, 4685, 9369, 8732, 7456, 4906, 9811, 9616, 9224, 8442, 6876, 3746, 7491, 4976, 9951, 9896, 9784, 9562, 9116, 8226, 6444, 2882, 5763, 1520, 3039, 6079, 2150, 4301, 8601, 7196, 4384, 8769, 7530, 5054, 100, 201, 401, 803, 1605, 3211, 6421, 2836, 5671, 1336, 2671, 5343, 678, 1357, 2713, 5427, 846, 1693, 3385, 6771, 3534, 7069, 4130, 8261, 6514, 3022, 6043, 2080, 4159, 8319, 6630, 3254, 6507, 3008, 6015, 2024, 4047, 8095, 6182, 2358, 4715, 9431, 8854, 7702, 5396, 786, 1571, 3143, 6285, 2564, 5127, 248, 495, 991, 1981, 3963, 7925, 5844, 1680, 3361, 6721, 3436, 6871, 3736, 7471, 4936, 9871, 9736, 9464, 8922, 7836, 5666, 1324, 2649, 5297, 588, 1175, 2351, 4701, 9403, 8798, 7590, 5172, 338, 675, 1351, 2701, 5403, 798, 1597, 3193, 6387, 2766, 5533, 1058, 2117, 4233, 8467, 6926, 3846, 7691, 5376, 744, 1489, 2977, 5955, 1902, 3805, 7609, 5212, 416, 833, 1665, 3331, 6661, 3316, 6631, 3256, 6511, 3016, 6031, 2056, 4111, 8223, 6438, 2870, 5739, 1472, 2943, 5887, 1766, 3533, 7065, 4124, 8247, 6488, 2968, 5937, 1866, 3733, 7465, 4924, 9847, 9688, 9368, 8730, 7452, 4898, 9795, 9584, 9160, 8314, 6620, 3234, 6467, 2928, 5855, 1704, 3407, 6815, 3622, 7245, 4482, 8965, 7922, 5838, 1668, 3337, 6673, 3340, 6679, 3352, 6703, 3400, 6799, 3592, 7183, 4360, 8719, 7432, 4856, 9713, 9418, 8830, 7652, 5298, 588, 1177, 2353, 4707, 9413, 8820, 7632, 5258, 508, 1017, 2033, 4067, 8133, 6260, 2512, 5025, 42, 85, 169, 339, 677, 1355, 2709, 5419, 830, 1661, 3321, 6643, 3278, 6557, 3106, 6213, 2418, 4837, 9673, 9340, 8672, 7338, 4668, 9337, 8666, 7326]
print(ls[int(input())])
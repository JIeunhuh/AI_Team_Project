from flask import Flask, request, jsonify
import requests
from PIL import Image
import numpy as np
import pickle
import os

app = Flask(__name__)

# 모델 로드
with open('imagecaption.h5', 'rb') as p:
    model = pickle.load(p)

# 이미지 처리 함수
def process_image(image_url):
    response = requests.get(image_url)
    image = Image.open(io.BytesIO(response.content))

    # 이미지 전처리 및 모델 예측
    # 이미지를 모델의 입력 형식에 맞게 변환하고 예측 수행
    # (이미지를 특징 벡터로 변환하는 부분을 추가해야 할 수 있음)
    image = preprocess_image(image)  # 전처리 함수를 자신의 모델에 맞게 수정해야 합니다.
    caption = generateCaption(image)  # 모델을 통해 캡션 생성

    return caption

# 이미지 URL을 받아 결과 반환
@app.route('/process_image', methods=['POST'])
def process_image_endpoint():
    data = request.get_json()
    image_url = data['image_url']

    # 이미지 처리 함수 호출
    result = process_image(image_url)

    # 결과를 JSON 형식으로 반환
    return jsonify({'result': result})

if __name__ == '__main__':
    app.run(debug=True)


import numpy as np
from tensorflow.python.keras.models import load_model
import tensorflow as tf
from tensorflow.python.keras_preprocessing.image import image
from flask import Flask, request, jsonify

captioning_model = load_model('./imagecaption.h5')

def preprocess_image(image_path):
    img = image.load_img(image_path, target_size=(224, 224))
    img = image.img_to_array(img)
    img = np.expand_dims(img, axis=0)
    img = preprocess_input(img)
    return img

def generate_caption(image_path):
    img = preprocess_image(image_path)
    caption = captioning_model.predict(img)
    # 캡션을 디코딩하고 반환하는 로직을 추가하세요
    return caption

def decode_caption(caption):
    # 캡션을 디코딩하는 로직을 추가하세요
    return decoded_caption


app = Flask(__name__)

@app.route('/generate_caption', methods=['POST'])
def generate_caption_endpoint():
    try:
        # 이미지 파일을 받아옴
        uploaded_file = request.files['file']
        
        # 캡션을 생성하기 위해 이미지와 모델을 전달
        caption = generate_caption(uploaded_file)
        
        return jsonify({'caption': caption})
    except Exception as e:
        return jsonify({'error': str(e)}), 400

if __name__ == '__main__':
    app.run(debug=True)
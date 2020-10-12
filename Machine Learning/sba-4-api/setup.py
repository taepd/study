import setuptools
# root directory 에서 pip install . 하면 setup.py가 실행

with open("README.md", "r") as fh:
    long_description = fh.read()

setuptools.setup(
    name='com_sba_api',
    version='1.0',
    description='Python Distribution Utilities',
    author='taeyoungdon',
    author_email='taepd1@gamil.com',
    url='https://www.python.org/sigs/distutils-sig/',
    packages=setuptools.find_packages(),
)


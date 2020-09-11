from xml.etree.ElementTree import Element
from xml.etree.ElementTree import SubElement
from xml.etree.ElementTree import ElementTree

note = Element('note')
note.attrib['no'] = '100'

SubElement(note, 'to').text = 'Tove'
SubElement(note, 'from').text = 'Jani'
SubElement(note, 'heading').text = 'Reminder'
SubElement(note, 'body').text = "Don't forget me this weekend!"


def indent(elem, level=0):
    mytab = '\t'
    i = '\n' + level * mytab

    if len(elem):
        if not elem.text or not elem.text.strip():
            elem.text = i + mytab

        if not elem.tail or not elem.tail.strip():
            elem.tail = i

        for elem in elem:
            indent(elem, level + 1)

        if not elem.tail or not elem.tail.strip():
            elem.tail = i
    else:
        if level and (not elem.tail or not elem.tail.strip()):
            elem.tail = i


indent(note)

xmlFile = 'xmlEx_01_ex.xml'
ElementTree(note).write(xmlFile, encoding='utf-8')

print(xmlFile + ' 파일이 생성되었습니다.')

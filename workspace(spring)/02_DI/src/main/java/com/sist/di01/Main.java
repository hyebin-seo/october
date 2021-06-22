package com.sist.di01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		
		/*
		 * - �������� ��ü�� �����ϰ� ������ ��ü�� �������ִ� ������ ������ ��.
		 * - ���⿡ �ִ� GenericXmlApplicationContext ��ü�� ������ ����� ������ Ŭ����.
		 * - �����⿡�� ������ ��ü�� �����̰�, �� ��ü�� ��� �����ϴ� ���� ���� ������ xml ���Ͽ� ������ �Ǿ� ����.
		 * - GenericXmlApplicationContext Ŭ������ xml ���Ͽ� ���ǵ� ���� ������ �о�ͼ� ��ü�� �����ϰ�,
		 *   ������ ��ü�� ������ �ڿ� ���������� ������.
		 * - xml�� �̿��� ������ ���� ���Ͽ����� �����̳ʰ� ������ ��ü�� �����ϱ� ���� <bean> �±׸� �����.
		 * - ������ �����̳ʰ� �����ؼ� �����ϴ� ��ü�� ��Ʈ�� ��(bean) ��ü��� �θ��� �Ϲ������� �ڹ� ��ü�� ������.
		 * - ������ �����̳ʴ� ������ �� ��ü�� <�̸�, �� ��ü> ������ ������.
		 * - ������ �����̳ʰ� �����ϰ� �ִ� ��ü�� ����ϰ� ���� ��� �� ��ü�� ����Ǿ� �ִ� �̸��� �̿��ؼ� ��ü ����.
		*/
		
		/*
		 * ������ �����̳��� ���� 
		 * - BeanFactory : �ܼ��� ������ �����̳ʿ��� ��ü�� �����ϰ� DI�� ó�����ִ� ����� �����ϴ� ��ü.
		 *   �������� ����ϴ� ������ �ܼ��� DI����� ���ؼ��� �ƴ϶�, �������� ����ϴ� �پ��� �ΰ����
		 *   (Ʈ����� ó��, �ڹ� �ڵ� ����� ������ ����, �ֳ����̼��� �̿��� �� ����, �������� �̿��� �� ���� ��)
		 *   �����ε� �̷��� �ΰ����� ����� ����ϱ� ���ؼ��� ApplicationContext��ü�� �ַ� ���.
		 * - AbstractApplicationContext : �����̳� ����(close)�� ���� ����� ������ �ִ� ��ü.
		 * - GenericXmlApplicationContext : AbstractApplicationContext ��ü�� ��� �޾� ����� Ŭ����. xml ���Ͽ��� ������ �� ���� ������ �о���� ����.
		 * - GenericXmlApplicationContext ��ü�� ������ �� �Ķ���� ������ xml�� ��θ� �����Ͽ� ���� ���Ϸ� �����.
		 * - GenericXmlApplicationContext ��ü�� ���޹��� xml ���Ͽ��� ���� ������ �о�ͼ� ������ �� ��ü�� �����ϰ� ������Ƽ ���� ������.
		 *   ������ ������ �� ��ü�� getBean() �̶�� �޼��带 ����ؼ� ������.
		 *   getBean() �޼����� ù���� �Ķ���ʹ� �����ϰ��� �ϴ� ������ �� ��ü�� ������ id�̸��̸�, �ι�° �Ķ���ʹ� �� ��ü�� Ÿ���� �ǹ���.
		 */
		
		/* 
		 * - DI ��, ������ ��� �� �������� xml ������ ������ �Ǿ� ����.
		 * - ������ �����̳��� ctx�� "classpath:getsum.xml" ������ ���� DI�� ����.
		 * - getsum.xml ������ resources ������ �� �־�� ��.
		 * 
		 */
		
		// DI �۾��� ���ִ� ������ �����̳� ����
		// xml ������ �̿��Ͽ� �޸𸮷� ������ �����̳� ��ü ����(�޸𸮷� �ε�)
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:getsum.xml");
		
		// bean �����س��� id�� bean�� �����´�. : ���� �� �ڵ忡�� ���� ������ �Ͼ�� ��.
		// new Ű���带 ������� �ʰ� ���� ������ �����̳ʿ��� ������ ���.
		// ��� 2����
//		MyGetSum my = (MyGetSum) ctx.getBean("mySum");
		MyGetSum my = (MyGetSum) ctx.getBean("mySum", MyGetSum.class);
		my.sum();
		
		// bean�� ��������� �ݳ��ؾ���.
		ctx.close();
	}
}

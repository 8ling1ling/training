package cn.sunline.tiny.demo.mapper;

/**
 * mapper Base classes of files
 * @param <E>
 *     Entity Class
 * @param <C>
 *     Conditional Query Class
 * @param <P>
 *     Primary Key Type
 */
public interface BaseMapper<E,P> {

	int deleteById(P id);

	P insert(E record);

	E selectById(P id);

	int updateById(E record);

}